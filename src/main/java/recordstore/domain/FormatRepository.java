package recordstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FormatRepository extends CrudRepository<Format, Long> {
	List<Format> findByName(String name);

}
