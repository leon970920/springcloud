package springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.service.PaymentService;

/**
 * @Author chengliang
 * @Date 2022/5/24 23:29
 */

@RestController
public class CircleBreakerController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("consumer/paymentSQL/{id}")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }


}

