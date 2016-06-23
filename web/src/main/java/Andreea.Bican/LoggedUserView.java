package Andreea.Bican;

import Andreea.Bican.impl.IAccessToken;
import Andreea.Bican.impl.Oauth2.FacebookAuthentication.FacebookAccessToken;
import Andreea.Bican.impl.Oauth2.GoogleAuthentication.GoogleAccessToken;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andre on 21.06.2016.
 */
@RestController
public class LoggedUserView {

    @RequestMapping(value="/danceclasses", method = RequestMethod.GET)
    public String danceClasses(@RequestHeader("token")String token) throws Exception {
        IAccessToken accessToken;
        if(CurrentUser.getUser().getProvider() == null){
            return "No provider";
        }
        System.out.println(CurrentUser.getUser().getProvider());
        if(CurrentUser.getUser().getProvider().equals("facebook")){
            accessToken = new FacebookAccessToken();
        }else {
            accessToken = new GoogleAccessToken();
        }
        if(accessToken.checkToken(token)){
            return "You are logged, " + CurrentUser.getUser().getName();
        }
        else{
            return "You are not logged";
        }
    }

}
