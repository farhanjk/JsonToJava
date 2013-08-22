
package com.latest.items;

import java.util.List;

public class Theme{
   	private String backgroundColor;
   	private String backgroundColor2;
   	private ThemeLogoImage themeLogoImage;

 	public String getBackgroundColor(){
		return this.backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor){
		this.backgroundColor = backgroundColor;
	}
 	public String getBackgroundColor2(){
		return this.backgroundColor2;
	}
	public void setBackgroundColor2(String backgroundColor2){
		this.backgroundColor2 = backgroundColor2;
	}
 	public ThemeLogoImage getThemeLogoImage(){
		return this.themeLogoImage;
	}
	public void setThemeLogoImage(ThemeLogoImage themeLogoImage){
		this.themeLogoImage = themeLogoImage;
	}
}
