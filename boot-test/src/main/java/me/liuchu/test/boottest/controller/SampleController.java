package me.liuchu.test.boottest.controller;

import me.liuchu.test.boottest.model.dto.param.SampleParam;
import me.liuchu.test.boottest.model.dto.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author liuchu
 * Date 2019/5/22
 * Time 16:58
 */

@RestController
@RequestMapping("/sample")
public class SampleController {

    @PostMapping("test")
    public Response test(@RequestBody @Valid SampleParam param) {
        System.out.println("Received data, name is " + param.getUsername());
        return Response.ok();
    }
}
