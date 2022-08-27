package com.aaron.springmvcproject.gallery;

import java.util.List;

public interface GalleryMapper {
	public abstract int upload(Gallery g);

	public abstract List<Gallery> readAllPhotos();
	
	public abstract Gallery deleteCheck(Gallery g);
	
	public abstract int delete(Gallery g);
}
