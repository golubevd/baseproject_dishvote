package baseproject.dishvote.service;


import baseproject.dishvote.Util.exception.NotFoundException;
import baseproject.dishvote.model.Restaurant;
import baseproject.dishvote.repository.JpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static baseproject.dishvote.Util.ValidationUtil.checkNotFound;
import static baseproject.dishvote.Util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final JpaRestaurantRepository repository;

    @Autowired
    public RestaurantService(JpaRestaurantRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @CacheEvict(value = { "restaurants", "dishes", "dishesofday"}, allEntries = true)
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Restaurant getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    @Cacheable("restaurants")
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        repository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void evictCache() {
        // only for evict cache
    }
}
