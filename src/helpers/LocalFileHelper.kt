package dev.remylavergne.halo.helpers

import java.io.File

/**
 * Permet de gérer l'accès à des fichiers locaux, tels que les logs, etc...
 */
object LocalStorageHelper {

    lateinit var httpErrorsLogs: File
        private set

    fun createDirectory(path: String = "default"): File {
        val newDir = File(path)
        newDir.mkdir()
        return newDir
    }

    fun createFile(filename: String, path: String = "default"): File {
        val dir = LocalStorageHelper.createDirectory(path)
        val file = File(dir, filename)
        val isFileAlreadyCreated = file.createNewFile()
        return file
    }

    fun initLogsFile() {
        this.httpErrorsLogs = LocalStorageHelper.createFile("http-errors-logs.txt", "logs")
    }

}