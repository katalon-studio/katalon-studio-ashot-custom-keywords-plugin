package com.katalon.plugin.keyword.ashot

import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

class Shot {

	@Keyword
	def ashot(String format, String path) {
		def webDriver = DriverFactory.getWebDriver()
		BufferedImage bi = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(webDriver)
				.getImage()
		File outputfile = new File(path)
		try {
			ImageIO.write(bi, format, outputfile)
		} catch (IOException e) {
			e.printStackTrace()
		}

		KeywordUtil.logInfo("Output ${outputfile.getAbsolutePath()}")
	}
}