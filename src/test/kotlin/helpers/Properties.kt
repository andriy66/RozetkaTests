package helpers

import java.io.File
import java.io.File.separator
import java.io.FileInputStream
import java.net.URL
import java.util.Properties

class Properties {
    companion object {
        private val properties = Properties()
        private val path = FileInputStream("src${separator}test${separator}resources${separator}data.properties")

        fun getProperty(key: String): String {
            properties.load(path)
            return properties.getProperty(key)
        }

        val URL = URL(getProperty("url"))
        val PLATFORM_NAME = "Android"
        //val DEVICE_NAME = "Pixel_4_API_30"
        val DEVICE_NAME = "Pixel_3_API_30"
        val PLATFORM_VERSION = "11"
        val PATH =
            File("src${separator}test${separator}resources${separator}app-envprod-homeaway-debug.apk").absolutePath
    }
}