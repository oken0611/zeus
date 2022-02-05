package jp.co.techbrain.zeus.service.login;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Data

@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {

    /** アカウント情報 */
    private final AccountDto account;

    /**
     * ログインユーザー情報
     *
     * @param account
     * @param role
     */
    public LoginUserDetails(AccountDto account, String role) {

        super(account.getLoginId(), account.getPassword(), AuthorityUtils.createAuthorityList(role));

        this.account = account;

    }
}