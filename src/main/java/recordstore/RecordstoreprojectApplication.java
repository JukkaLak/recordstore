package recordstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import recordstore.domain.Album;
import recordstore.domain.AlbumRepository;
import recordstore.domain.Format;
import recordstore.domain.FormatRepository;
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
	public CommandLineRunner albumDemo(AlbumRepository albumRepository, GenreRepository genreRepository, FormatRepository formatRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Save some albums");
			Genre genre1 = new Genre("Metal");
			genreRepository.save(genre1);
			Genre genre2 = new Genre("Rap");
			genreRepository.save(genre2);
			Genre genre3 = new Genre("Rock");
			genreRepository.save(genre3);
			Format format1 = new Format("CD");
			formatRepository.save(format1);
			Format format2 = new Format("Vinyl");
			formatRepository.save(format2);
			
			
			albumRepository.save(new Album("In Flames", "Foregone", 2023, format2, 19.90, genre1));
			albumRepository.save(new Album("Laineen Kasperi", "Saatana saapuu Sörnäisiin", 2008, format1, 9.90, genre2));
			albumRepository.save(new Album("Ursus Factory", "Pinkki pilvi", 2019, format2, 9.90, genre3));
			
			//Luodaan käyttäjät admin ja user
			User user1 = new User("user", "$2a$10$j87Srx0Xse22rCh.t60kIu7IRYeR3pDP8gDnA8lM6J3XbVyqcE7c6", "USER");
			User user2 = new User("admin", "$2a$10$JaT7Aofo8cljVazjYVAvhOk5QX/Kt5iHRHj1EF.v4Ro/3x1SAIOFm", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			log.info("Fetch all albums");
			for (Album album : albumRepository.findAll()) {
				log.info(album.toString());
			}
			
		};
		
	}

}
