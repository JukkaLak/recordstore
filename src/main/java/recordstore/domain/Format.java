package recordstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Format {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long formatId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "format")
	
	private List<Album> albums;
	
	public Format() {}
	
	public Format(String name) {
		super();
		this.name = name;
	}

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Format formatId=" + formatId + ", name=" + name;
	}
	

}
