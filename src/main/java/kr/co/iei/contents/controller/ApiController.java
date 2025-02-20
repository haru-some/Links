package kr.co.iei.contents.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.iei.contents.model.service.ApiService;
import kr.co.iei.contents.model.vo.ApiMovie;


@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private ApiService apiService;
	
	 @ResponseBody
	 @GetMapping(value="/nowPlaying")
	    public List nowPlayingMovies() {
		 	List movieList = null;
			try {
				movieList = apiService.nowPlayingMovies();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(movieList.toString());
			return movieList;
	}
    @GetMapping(value="/movieDetail")
    public String MovieDetail(int movieId, Model model ) {
		ApiMovie movie = null;
		try {
			movie = apiService.movieDetail(movieId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("movie",movie);
		System.out.println(movie);
        return "contents/movieDetail";
	}
    
    //검색어를 받아서 searchMovie.html로 이동
    @GetMapping("/searchMovie")
    public String searchMovie(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("query", query);
        return "search/searchMovie";
    }
	/*
	@ResponseBody
	@GetMapping("/insertref")
	public String insertRef() {
		apiService.insertCountry();
		return "redirect:/contents/movieList";
	}
	*/
}
