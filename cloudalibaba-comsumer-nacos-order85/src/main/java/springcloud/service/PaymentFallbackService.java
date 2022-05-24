package springcloud.service;

import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author chengliang
 * @Date 2022/5/25 0:11
 */

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444,"Feign 服务降级，-------PaymentFallbackService");
    }
}
