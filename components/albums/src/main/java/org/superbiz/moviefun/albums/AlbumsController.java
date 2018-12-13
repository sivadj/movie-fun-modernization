package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private AlbumsBean albumsBean;

    public AlbumsController(AlbumsBean albumsBean) {
        this.albumsBean = albumsBean;
    }

    @PostMapping
    public void addMovie(@RequestBody Album album) {
        albumsBean.addAlbum(album);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbumId(@PathVariable Long albumId) {
        Album album = albumsBean.find(albumId);
        albumsBean.deleteAlbum(album);
    }



    @GetMapping
    public List<Album> find(
        @RequestParam(name = "field", required = false) String field,
        @RequestParam(name = "key", required = false) String key,
        @RequestParam(name = "start", required = false) Integer start,
        @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {

            return albumsBean.getAlbums();
        }
    }
