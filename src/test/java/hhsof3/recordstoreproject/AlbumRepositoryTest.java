package hhsof3.recordstoreproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import recordstore.domain.Album;
import recordstore.domain.AlbumRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AlbumRepositoryTest {
	
	@Autowired
	private AlbumRepository repository;
	
	@Test
	public void findByArtist() {
		List<Album> albums = repository.findByArtist("In Flames");
		
		assertThat(albums).hasSize(1);
		assertThat(albums.get(0).getAlbumName()).isEqualTo("Foregone");
	}
	
	@Test
	public void createNewAlbum() {
		Album album = new Album("Kamelot", "The Awakening", 2023, null, 0, null);
		repository.save(album);
		assertThat(album.getId()).isNotNull();
	}

}
