package me.liuchu.test.boottest.model.dto.param;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author liuchu
 * Date 2019/5/22
 * Time 16:54
 */
@Data
public class SampleParam {

    @NotNull(message = "username can't be null")
    private String username;

    @Range(min = 10, max = 40, message = "age only can be 10~40")
    private Integer age;

    private Profile profile;

    @Data
    public static class Profile {

        @NotNull(message = "when profile is involved, group can't be null")
        private String group;
        private String detail;
    }

    public static void main(String[] args) {
        SampleParam param = new SampleParam();
        param.setAge(15);
        param.setUsername("liuchu");

        Profile profile = new Profile();
        profile.setGroup("developer");
        profile.setDetail("group for developer");

        param.setProfile(profile);

        System.out.println(JSON.toJSONString(param, true));
    }

}
