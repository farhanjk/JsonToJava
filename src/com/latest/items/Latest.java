
package com.latest.items;

import java.util.List;

public class Latest{
   	private String description;
   	private String editorialUrlKey;
   	private String id;
   	private List<Images> images;
   	private String seriesTitle;
   	private Theme theme;
   	private String title;
   	private String type;
   	private String urlKey;

 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public String getEditorialUrlKey(){
		return this.editorialUrlKey;
	}
	public void setEditorialUrlKey(String editorialUrlKey){
		this.editorialUrlKey = editorialUrlKey;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public List<Images> getImages(){
		return this.images;
	}
	public void setImages(List<Images> images){
		this.images = images;
	}
 	public String getSeriesTitle(){
		return this.seriesTitle;
	}
	public void setSeriesTitle(String seriesTitle){
		this.seriesTitle = seriesTitle;
	}
 	public Theme getTheme(){
		return this.theme;
	}
	public void setTheme(Theme theme){
		this.theme = theme;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public String getUrlKey(){
		return this.urlKey;
	}
	public void setUrlKey(String urlKey){
		this.urlKey = urlKey;
	}
}
