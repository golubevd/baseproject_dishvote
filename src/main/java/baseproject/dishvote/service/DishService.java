package baseproject.dishvote.service;


import baseproject.dishvote.Util.exception.NotFoundException;
import baseproject.dishvote.model.Dish;

import baseproject.dishvote.repository.JpaDishRepository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static baseproject.dishvote.Util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {

    private final JpaDishRepository dishRepository;

    public DishService(JpaDishRepository repository){this.dishRepository = repository;}

    @CacheEvict(value="dishes", allEntries =  true)
    public Dish create(Dish dish)
    {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish);
    }

    @CacheEvict(value = {"dishes", "dishesofday"}, allEntries =  true)
    public void delete(int id) throws NotFoundException
    {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

    public Dish get(int id) throws NotFoundException {
        return checkNotFoundWithId(dishRepository.get(id), id);
    }

    @Cacheable("dishes")
    public List<Dish> getAll() {
        return dishRepository.getAll();
    }

    @CacheEvict(value = "dishes", allEntries = true)
    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        dishRepository.save(dish);
    }

    @CacheEvict(value = "dishes", allEntries = true)
    public void evictCache() {
        // only for evict cache
    }

}
