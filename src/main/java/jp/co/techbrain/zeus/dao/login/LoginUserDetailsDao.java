package jp.co.techbrain.zeus.dao.login;

import jp.co.techbrain.zeus.service.login.AccountDto;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface LoginUserDetailsDao {

    @Select
    AccountDto selectByLoginId(String loginId);
}
