package com.helpingHands.Email;

public class MailPage {
		
	public static String getConformationPage(String name,String link) {
		String body= "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"	<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\r\n" + 
				"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"	<!--[if !mso]><!-->\r\n" + 
				"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"	<!--<![endif]-->\r\n" + 
				"	<title>Helping Hands &#8211; Request and Donor management System</title>\r\n" + 
				"	<!--[if !mso]><!-->\r\n" + 
				"	<!--<![endif]-->\r\n" + 
				"	<style type=\"text/css\">\r\n" + 
				"		body {\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"		table,\r\n" + 
				"		td,\r\n" + 
				"		tr {\r\n" + 
				"			vertical-align: top;\r\n" + 
				"			border-collapse: collapse;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"		* {\r\n" + 
				"			line-height: inherit;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"		a[x-apple-data-detectors=true] {\r\n" + 
				"			color: inherit !important;\r\n" + 
				"			text-decoration: none !important;\r\n" + 
				"		}\r\n" + 
				"	</style>\r\n" + 
				"	<style type=\"text/css\" id=\"media-query\">\r\n" + 
				"		@media (max-width: 745px) {\r\n" + 
				"\r\n" + 
				"			.block-grid,\r\n" + 
				"			.col {\r\n" + 
				"				min-width: 320px !important;\r\n" + 
				"				max-width: 100% !important;\r\n" + 
				"				display: block !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.block-grid {\r\n" + 
				"				width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.col {\r\n" + 
				"				width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.col>div {\r\n" + 
				"				margin: 0 auto;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			img.fullwidth,\r\n" + 
				"			img.fullwidthOnMobile {\r\n" + 
				"				max-width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col {\r\n" + 
				"				min-width: 0 !important;\r\n" + 
				"				display: table-cell !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack.two-up .col {\r\n" + 
				"				width: 50% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num4 {\r\n" + 
				"				width: 33% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num8 {\r\n" + 
				"				width: 66% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num4 {\r\n" + 
				"				width: 33% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num3 {\r\n" + 
				"				width: 25% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num6 {\r\n" + 
				"				width: 50% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num9 {\r\n" + 
				"				width: 75% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.video-block {\r\n" + 
				"				max-width: none !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.mobile_hide {\r\n" + 
				"				min-height: 0px;\r\n" + 
				"				max-height: 0px;\r\n" + 
				"				max-width: 0px;\r\n" + 
				"				display: none;\r\n" + 
				"				overflow: hidden;\r\n" + 
				"				font-size: 0px;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.desktop_hide {\r\n" + 
				"				display: block !important;\r\n" + 
				"				max-height: none !important;\r\n" + 
				"			}\r\n" + 
				"		}\r\n" + 
				"	</style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #f6f8f8;\">\r\n" + 
				"	<!--[if IE]><div class=\"ie-browser\"><![endif]-->\r\n" + 
				"	<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f6f8f8; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#f6f8f8\" valign=\"top\">\r\n" + 
				"		<tbody>\r\n" + 
				"			<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"				<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\r\n" + 
				"					<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#f6f8f8\"><![endif]-->\r\n" + 
				"					<div style=\"background-color:#2b3940;\">\r\n" + 
				"						<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 725px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\r\n" + 
				"							<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
				"								<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#2b3940;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:725px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]><td align=\"center\" width=\"725\" style=\"background-color:transparent;width:725px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
				"								<div class=\"col num12\" style=\"min-width: 320px; max-width: 725px; display: table-cell; vertical-align: top; width: 725px;\">\r\n" + 
				"									<div style=\"width:100% !important;\">\r\n" + 
				"										<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"											<!--<![endif]-->\r\n" + 
				"											<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\r\n" + 
				"												<tbody>\r\n" + 
				"													<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"														<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 20px; padding-bottom: 0px; padding-left: 20px;\" valign=\"top\">\r\n" + 
				"															<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid #404D53; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\r\n" + 
				"																<tbody>\r\n" + 
				"																	<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"																		<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"																	</tr>\r\n" + 
				"																</tbody>\r\n" + 
				"															</table>\r\n" + 
				"														</td>\r\n" + 
				"													</tr>\r\n" + 
				"												</tbody>\r\n" + 
				"											</table>\r\n" + 
				"											<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										</div>\r\n" + 
				"										<!--<![endif]-->\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div style=\"background-color:transparent;\">\r\n" + 
				"						<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 725px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\r\n" + 
				"							<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
				"								<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:725px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]><td align=\"center\" width=\"725\" style=\"background-color:transparent;width:725px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
				"								<div class=\"col num12\" style=\"min-width: 320px; max-width: 725px; display: table-cell; vertical-align: top; width: 725px;\">\r\n" + 
				"									<div style=\"width:100% !important;\">\r\n" + 
				"										<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"											<!--<![endif]-->\r\n" + 
				"											<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\r\n" + 
				"												<tbody>\r\n" + 
				"													<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"														<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\r\n" + 
				"															<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;\" align=\"center\" role=\"presentation\" height=\"30\" valign=\"top\">\r\n" + 
				"																<tbody>\r\n" + 
				"																	<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"																		<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" height=\"30\" valign=\"top\"><span></span></td>\r\n" + 
				"																	</tr>\r\n" + 
				"																</tbody>\r\n" + 
				"															</table>\r\n" + 
				"														</td>\r\n" + 
				"													</tr>\r\n" + 
				"												</tbody>\r\n" + 
				"											</table>\r\n" + 
				"											<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										</div>\r\n" + 
				"										<!--<![endif]-->\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div style=\"background-color:transparent;\">\r\n" + 
				"						<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 725px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #ffffff;\">\r\n" + 
				"							<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\r\n" + 
				"								<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:725px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]><td align=\"center\" width=\"725\" style=\"background-color:#ffffff;width:725px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
				"								<div class=\"col num12\" style=\"min-width: 320px; max-width: 725px; display: table-cell; vertical-align: top; width: 725px;\">\r\n" + 
				"									<div style=\"width:100% !important;\">\r\n" + 
				"										<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"											<!--<![endif]-->\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 20px; padding-bottom: 5px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#0068a5;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.8;padding-top:20px;padding-right:40px;padding-bottom:5px;padding-left:40px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.8; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; color: #0068a5; mso-line-height-alt: 25px;\"><span style=\"font-size: 30px; line-height: 54px;\" data-mce-style=\"font-size: 30px; line-height: 54px;\"><strong>HelpingHands</strong></span></div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\r\n" + 
				"												<tbody>\r\n" + 
				"													<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"														<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"															<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid #BBBBBB; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\r\n" + 
				"																<tbody>\r\n" + 
				"																	<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"																		<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"																	</tr>\r\n" + 
				"																</tbody>\r\n" + 
				"															</table>\r\n" + 
				"														</td>\r\n" + 
				"													</tr>\r\n" + 
				"												</tbody>\r\n" + 
				"											</table>\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 13px; padding-bottom: 15px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.8;padding-top:13px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.8; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 25px;\">\r\n" + 
				"													<p style=\"font-size: 14px; line-height: 1.8; word-break: break-word; text-align: left; mso-line-height-alt: 25px; margin: 0;\">Hello&nbsp;"+ name +",</p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<div class=\"img-container center fixedwidth\" align=\"center\" style=\"padding-right: 16px;padding-left: 16px;\">\r\n" + 
				"												<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 16px;padding-left: 16px;\" align=\"center\"><![endif]-->\r\n" + 
				"												<div style=\"font-size:1px;line-height:16px\">&nbsp;</div><img class=\"center fixedwidth\" align=\"center\" border=\"0\" src=\"https://static8.depositphotos.com/1378583/988/v/450/depositphotos_9881312-stock-illustration-helping-hand.jpg\" alt=\"Logo\" title=\"Logo\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 145px; display: block;\" width=\"145\">\r\n" + 
				"												<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 35px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:35px;padding-right:40px;padding-bottom:0px;padding-left:40px;\">\r\n" + 
				"												<div style=\"line-height: 1.5; font-size: 12px; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"													<p style=\"font-size: 34px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 51px; margin: 0;\"><span style=\"font-size: 34px; color: #2b3940;\"><strong>Welcome to Helping Hands!</strong></span></p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 13px; padding-bottom: 15px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.8;padding-top:13px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.8; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 25px;\">\r\n" + 
				"													<p style=\"font-size: 14px; line-height: 1.8; word-break: break-word; text-align: left; mso-line-height-alt: 25px; margin: 0;\">To activate your account please click the button below to verify your email address:</p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<div class=\"button-container\" align=\"center\" style=\"padding-top:10px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\r\n" + 
				"												<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 10px; padding-right: 40px; padding-bottom: 15px; padding-left: 40px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\""+ link +"\" style=\"height:39pt; width:175.5pt; v-text-anchor:middle;\" arcsize=\"10%\" stroke=\"false\" fillcolor=\"#2d8cff\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]--><a href=\""+ link +"\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #2d8cff; border-radius: 5px; -webkit-border-radius: 5px; -moz-border-radius: 5px; width: auto; width: auto; border-top: 1px solid #2d8cff; border-right: 1px solid #2d8cff; border-bottom: 1px solid #2d8cff; border-left: 1px solid #2d8cff; padding-top: 10px; padding-bottom: 10px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:28px;padding-right:28px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; margin: 0; line-height: 2; word-break: break-word; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 32px;\">Activate Account</span></span></a>\r\n" + 
				"												<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 13px; padding-bottom: 15px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.8;padding-top:13px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.8; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 25px;\">\r\n" + 
				"													<p style=\"font-size: 14px; line-height: 1.8; word-break: break-word; text-align: left; mso-line-height-alt: 25px; margin: 0;\">Or paste this link into your browser:<br>"+ link +"</p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 25px; padding-bottom: 25px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.8;padding-top:25px;padding-right:40px;padding-bottom:25px;padding-left:40px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.8; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 25px;\">\r\n" + 
				"													<p style=\"font-size: 14px; line-height: 1.8; word-break: break-word; text-align: left; mso-line-height-alt: 25px; margin: 0;\">Happy Helping!</p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										</div>\r\n" + 
				"										<!--<![endif]-->\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div style=\"background-color:transparent;\">\r\n" + 
				"						<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 725px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\r\n" + 
				"							<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
				"								<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:725px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]><td align=\"center\" width=\"725\" style=\"background-color:transparent;width:725px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\r\n" + 
				"								<div class=\"col num12\" style=\"min-width: 320px; max-width: 725px; display: table-cell; vertical-align: top; width: 725px;\">\r\n" + 
				"									<div style=\"width:100% !important;\">\r\n" + 
				"										<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"											<!--<![endif]-->\r\n" + 
				"											<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\r\n" + 
				"											<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"												<div style=\"font-size: 14px; line-height: 1.2; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 17px;\">\r\n" + 
				"													<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 17px; margin: 0;\">© 2020&nbsp;Helping Hands - All Rights Reserved.</p>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"											<!--[if (!mso)&(!IE)]><!-->\r\n" + 
				"										</div>\r\n" + 
				"										<!--<![endif]-->\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"								<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"				</td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tbody>\r\n" + 
				"	</table>\r\n" + 
				"	<!--[if (IE)]></div><![endif]-->\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
		
		return body;
	}
}
