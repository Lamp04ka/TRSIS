package labs.lb2;

import labs.lb2.ClassBirja;
import org.springframework.stereotype.Service;
import labs.lb2.BirjaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BirjaServiceImpl implements BirjaService {

    // Хранилище клиентов
    private static final Map<Integer, ClassBirja> BIRJA_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger BIRJA_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(ClassBirja Object) {
        final int birjaId = BIRJA_ID_HOLDER.incrementAndGet();
        Object.setId(birjaId);
        BIRJA_REPOSITORY_MAP.put(birjaId, Object);
    }

    @Override
    public List<ClassBirja> readAll() {
        return new ArrayList<>(BIRJA_REPOSITORY_MAP.values());
    }

    @Override
    public ClassBirja read(int id) {
        return BIRJA_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(ClassBirja Object, int id) {
        if (BIRJA_REPOSITORY_MAP.containsKey(id)) {
            Object.setId(id);
            BIRJA_REPOSITORY_MAP.put(id, Object);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return BIRJA_REPOSITORY_MAP.remove(id) != null;
    }

}
