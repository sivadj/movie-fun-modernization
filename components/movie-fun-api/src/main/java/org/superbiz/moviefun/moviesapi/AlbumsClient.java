package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

import static org.springframework.http.HttpMethod.GET;


public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;
    private static ParameterizedTypeReference<List<Album>> albumListType = new ParameterizedTypeReference<List<Album>>() {
    };


    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(Album album) {
        restOperations.postForEntity(albumsUrl, album, Album.class);
    }

    public Album find(long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl)
                .queryParam("albumId", id);
        return restOperations.exchange(builder.toUriString(), GET, null, Album.class).getBody();
    }

   


    public void deleteAlbum(Album album) {

    }


    public void updateAlbum(Album album) {

    }

    public List<Album> getAlbums() {

        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }
}
