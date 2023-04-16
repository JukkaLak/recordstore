package hhsof3.recordstoreproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import recordstore.web.RecordstoreController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecordstoreprojectApplicationTests {
	
	@Autowired
	private RecordstoreController recordstoreController;

	@Test
	public void contextLoads() {
		assertThat(recordstoreController).isNotNull();
	}

}
