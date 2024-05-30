package com.filtec.rest.client;

import com.filtec.rest.config.feign.FeignConfiguration;
import com.filtec.rest.dto.PagedResource;
import com.filtec.rest.dto.Session;
import com.filtec.rest.dto.request.MovieCreateRequest;
import com.filtec.rest.dto.request.SessionCreateRequest;
import com.filtec.rest.dto.response.MovieListResponse;
import com.filtec.rest.dto.response.MovieResponse;
import com.filtec.rest.dto.response.SessionListResponse;
import com.filtec.rest.dto.response.SessionResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cinema", url = "${services.cinema-service}", configuration = FeignConfiguration.class)
public interface CinemaClient {

    @PostMapping("/movies")
    ResponseEntity<MovieResponse> createMovie(MovieCreateRequest movieCreateRequest);

    @GetMapping("/movies")
    ResponseEntity<PagedResource<MovieListResponse>> getAllMoviePaginated(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    );

    @GetMapping("/movies/{movieId}")
    ResponseEntity<MovieResponse> getMovieById(@PathVariable Long movieId);

    @PostMapping("/movies/{movieId}/rooms/{roomId}")
    ResponseEntity<Session> createSession(
            @Valid @RequestBody SessionCreateRequest sessionCreateRequest,
            @PathVariable("movieId") Long movieId,
            @PathVariable("roomId") Long roomId
    );

    @RequestMapping(method = RequestMethod.GET, value = "/sessions")
    ResponseEntity<PagedResource<SessionListResponse>> getSessionPage(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    );

    @RequestMapping(method = RequestMethod.GET, value = "/sessions/{sessionId}")
    ResponseEntity<SessionResponse> getSession(@PathVariable Long sessionId);

    @RequestMapping(method = RequestMethod.PATCH, value ="/sessions/seats/{seatId}/mark-unavailable")
    Boolean updateSeatToUnavailable(@PathVariable Long seatId);
}
