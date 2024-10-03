package com.stver8935.riding.data.datasource

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.annotation.NonNull
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.util.Enumeration

/**
 *
 *
 * @packageName    : com.stver8935.riding.data.datasource
 * @fileName   : SecureStorage
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
class SecureStorage {

    private val keyPairProvider = "AndroidKeyStore"


    enum class SecureStorageAlias {
        REFRESH_TOKEN
    }


    fun generateSecureKey(alias: SecureStorageAlias): KeyPair {

        val keyPairGen = KeyPairGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_EC,
            keyPairProvider
        )

        val paramSpec: KeyGenParameterSpec = KeyGenParameterSpec.Builder(
            alias.name,
            KeyProperties.PURPOSE_SIGN
        ).run {
            setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
            build()
        }

        keyPairGen.initialize(paramSpec);

        return keyPairGen.generateKeyPair();
    }

    fun getKeyStore(): KeyStore{
        return KeyStore.getInstance(keyPairProvider).apply {
            load(null)
        }
        // keyStore.aliases()
    }

    fun aa(){
        val ks = getKeyStore();
        val entry: KeyStore.Entry = ks.getEntry("",null)
        entry !is KeyStore.PrivateKeyEntry
        


    }









}
