package com.example.myapplication.firebaseHelper;


import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;


public class FileUploader {
    private StorageReference mStorageRef;
    private StorageTask mUploadTask;

    private Context context ;
    private String url ;

    public FileUploader(Context context, String location ) {
        mStorageRef = FirebaseStorage.getInstance().getReference(location);
        this.context=context;
    }

   private String getUrl() {
        return url;
    }

    private String getFileExtension(Uri uri ) {

        ContentResolver cR = context.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }



    public String uploadFile( Uri uri){

        if (uri != null) {

            final StorageReference  fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(uri));

      mUploadTask= fileReference.putFile(uri);


            Task<Uri> urlTask = mUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    // Continue with the task to get the download URL
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        url=downloadUri.toString();
                    } else {
                        // Handle failures
                        // ...
                    }
                }
            });


                  /*  .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                            fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    url=uri.toString();
                                }
                            });

                          // url=taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();

                          // Toast.makeText(context, "File Uploaded "+" "+ url, Toast.LENGTH_LONG).show();

                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context , "failed to upload", Toast.LENGTH_SHORT).show();
                        }
                    });*/

        } else {
            Toast.makeText(context, "No file selected", Toast.LENGTH_SHORT).show();
        }
       return getUrl();
    }


}



