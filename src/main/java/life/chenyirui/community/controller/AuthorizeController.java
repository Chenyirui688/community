package life.chenyirui.community.controller;

import life.chenyirui.community.dto.AccessTokenDto;
import life.chenyirui.community.dto.GithubUser;
import life.chenyirui.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name="state")String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("3ac4d1c502cf23d98a8a");
        accessTokenDto.setClient_secret("1703b2cee5ce6555784003b42cec0e2871caad17");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8888/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
