package jp.co.techbrain.zeus.service.login;

import jp.co.techbrain.zeus.dao.login.LoginUserDetailsDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

    private final LoginUserDetailsDao loginUserDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        AccountDto accountDto = loginUserDetailsDao.selectByLoginId(loginId);

        //該当レコードが取得できなかった場合はエラーにする
        if  (accountDto   ==  null)   {
            throw new UsernameNotFoundException("Wrong email or password");
        }

        //ログインユーザー権限を設定
        String role = "ROLE_ADMIN";

        return new LoginUserDetails(accountDto, role);

    }
}
