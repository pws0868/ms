package study.ms.domain.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.ms.domain.member.Member;
import study.ms.domain.member.UserLogin;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop getShop(Integer idx) {
        return shopRepository.findByIdx(idx).orElse(new Shop());
    }
    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    public void save(Shop shop) {
        shopRepository.save(shop);
    }

}
