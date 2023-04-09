package recordstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String artist;
	private String albumName;
	@Column(name = "release year")
	private int year;
	private String format;
	private double price;
	
	@ManyToOne
	@JsonIgnoreProperties(value = "albums")
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	
	public Album() {}
	
	public Album(String artist, String albumName, int year, String format, double price, Genre genre) {
		super();
		this.artist = artist;
		this.albumName = albumName;
		this.year = year;
		this.format = format;
		this.price = price;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
			return "Album [id=" + id + ", artist=" + artist + ", albumName=" + albumName + ", year=" + year + ", format="
					+ format + ", price=" + price + ", genre=" + this.getGenre() + "]";
		return "Album [id=" + id + ", artist=" + artist + ", albumName=" + albumName + ", year=" + year + ", format="
				+ format + ", price=" + price +"]";
	}

	
	
	
	

}
