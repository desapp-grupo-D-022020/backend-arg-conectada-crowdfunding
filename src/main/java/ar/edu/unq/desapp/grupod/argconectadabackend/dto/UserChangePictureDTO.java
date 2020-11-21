package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserChangePictureDTO {
	private String userId;
	
	private MultipartFile img;

	public UserChangePictureDTO(String userId, MultipartFile img) {
		super();
		this.userId = userId;
		this.img = img;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
}
