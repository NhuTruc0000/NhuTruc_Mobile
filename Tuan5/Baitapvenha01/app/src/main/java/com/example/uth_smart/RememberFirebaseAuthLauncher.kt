package com.example.uth_smart

import android.content.IntentSender
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider


@Composable
fun rememberFirebaseAuthLauncher(
    onAuthComplete: (FirebaseUser) -> Unit,
    onAuthError: (Exception) -> Unit
): ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult> {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        try {
            val credential = Identity.getSignInClient(context)
                .getSignInCredentialFromIntent(result.data)
            val idToken = credential.googleIdToken
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(firebaseCredential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onAuthComplete(task.result?.user!!)
                    } else {
                        onAuthError(task.exception ?: Exception("Unknown error"))
                    }
                }
        } catch (e: Exception) {
            onAuthError(e)
        }
    }

    return launcher
}