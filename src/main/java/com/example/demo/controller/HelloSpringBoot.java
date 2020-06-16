package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Hello")
public class HelloSpringBoot {
   /* @Autowired
    private RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(HelloSpringBoot.class);
    // @Value("${user.names}")
    // private String name;
    @Autowired
    private User user;
    private RedisUtils redisUtils;

    @GetMapping(value = "/sayHello{id}")
    public User sayhello(@PathVariable int id) {
        redisTemplate.opsForValue().set("yj", "18");

        if (id <= 0) {
            logger.error("有用户+" + id + "未登录");
        }
        int i = 1;
        int s = 0;
        try {
            logger.info("xxl-带值" + id + "进入b方法");
            int b = 30 + id;
            logger.info("xxxxxx");
        } catch (Exception e) {
            logger.debug("b赋值出错", e);

        }
        int b = 2;
        int c = i + b;
        return user;
    }

    @GetMapping(value = "/queryUser")
    public String queryUser(@RequestParam long id) {
        //这里要注意在这里的id是long类型的数组

        Arrays.asList(id).stream().filter(i -> i > 1).collect(Collectors.toList());
        User user = new User();
        //String uId = UUID.randomUUID().toString();
        //System.out.println(id);
        //select * from table where id in (1,2,3,4);

        return null;
    }

    @GetMapping(value = "/testRedis")
    public void testRedis(@RequestParam String key, @RequestParam String value) {
        redisUtils.set(key, value);
        redisUtils.expire(key, 10);
    }

    @GetMapping(value = "/toBeNumberONE")
    public String toBeNumberONE(@RequestParam String uId, @RequestParam long time) {
        if (redisUtils.setAndExpire(uId, new String(), 10)) {
            return "充值成功";
        }
        return "充值失败";
    }

    @GetMapping(value = "/checkNumber")
    public String checkNumber(@RequestParam String uId) {
        if (redisUtils.hasKey(uId)) {
            return "登陆成功";
        }
        return "已经过期了";
    }

    @GetMapping(value = "/setNameSpace")
    public void setNameSpace() {
        String nameSpace = "KH81:";
        redisUtils.set(nameSpace + "wj", new String());
    }
   /*@GetMapping(value = "/checkReq")
    public boolean checkReq(){
        return redisUtils.c
   }*/
    /*
    返回点赞个数
     */
    /*@GetMapping(value = "/getzanNumber")
    public String getzanNumber() {
        return String.valueOf(redisUtils.get("zan:num"));
    }
*/
    /*
    点赞和取消点赞
     */
   /* @GetMapping(value = "/changeZanNumber")
    public String changeZanNumber() {
        if (!zanTrue()) {
            redisUtils.set("zan:num", String.valueOf(Integer.parseInt(String.valueOf(redisUtils.get("zan:num"))) + 1));
            redisUtils.set("zan:wj", "true");
            return "点赞成功";
        }
        redisUtils.set("zan:num", String.valueOf(Integer.parseInt(String.valueOf(redisUtils.get("zan:num"))) - 1));
        redisUtils.set("zan:wj", "false");
        return "取消点赞";
    }*/

    /*
    判断是否点过赞
     */
    /*@GetMapping(value = "/zanTrue")
    public boolean zanTrue() {
        if (redisUtils.hasKey("zan:wj")) {
            if (String.valueOf(redisUtils.get("zan:wj")) == "true") {
                return true;
            }
            return false;
        }
        return false;
    }*/
}
