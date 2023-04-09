package recordstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import recordstore.domain.Album;
import recordstore.domain.AlbumRepository;
import recordstore.domain.Genre;
import recordstore.domain.GenreRepository;
import recordstore.domain.User;
import recordstore.domain.UserRepository;



@SpringBootApplication
public class RecordstoreprojectApplication {
	private static final Logger log = LoggerFactory.getLogger(RecordstoreprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecordstoreprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner albumDemo(AlbumRepository albumRepository, GenreRepository genreRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Save some albums");
			Genre genre1 = new Genre("Metal");
			genreRepository.save(genre1);
			Genre genre2 = new Genre("Rap");
			genreRepository.save(genre2);
			Genre genre3 = new Genre("Rock");
			genreRepository.save(genre3);
			
			albumRepository.save(new Album("In Flames", "Foregone", 2023, "CD", 19.90, genre1));
			albumRepository.save(new Album("Laineen Kasperi", "Saatana saapuu Sörnäisiin", 2008, "Vinyl", 10.00, genre2));
			albumRepository.save(new Album("Ursus Factory", "Pinkki pilvi", 2019, "Vinyl", 9.90, genre3));
			
			//Luodaan käyttäjät admin ja user
			User user1 = new User("user", "$2a$10$vKELwTQYZzl7bBPxxZRm..BdZpQi3pt2GOq8EFOtyNf0Vle3TUBku", "USER");
			User user2 = new User("admin", "$2a$10$7tZP7K/He8jm7a2/uVPwAeZM7NtH/jbCwJpmv5hnZT6EKG7ShPOSa", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			log.info("Fetch all albums");
			for (Album album : albumRepository.findAll()) {
				log.info(album.toString());
			}
			
		};
		
	}

}
