package recordstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import recordstore.domain.Album;
import recordstore.domain.AlbumRepository;
import recordstore.domain.GenreRepository;

@Controller
public class RecordstoreController {
	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private GenreRepository grepository;
	
	//Näytä kaikki albumit
	@RequestMapping(value="/albumlist")
	public String albumList(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "albumlist";
	}
	
	//Näytä kaikki albumit REST
	@RequestMapping(value="/albums")
	public @ResponseBody List<Album> albumListRest(){
		return (List<Album>) repository.findAll();
	}
	
	//Näytä kaikki albumit id:n mukaan REST
	@RequestMapping(value="/album/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId){
		return repository.findById(albumId);
	}
	
	//Lisää uusi albumi
	@RequestMapping(value = "/add")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		model.addAttribute("genres", grepository.findAll());
		return "addalbum";
	}
	
	//Tallenna albumi
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Album album) {
		repository.save(album);
		return "redirect:albumlist";
	}
	
	//Poista albumi
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
		repository.deleteById(albumId);
		return "redirect:albumlist";
	}
	
	

}
