package jp.co.techbrain.zeus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静的リソースをセキュリティ対象外に設定
        web.ignoring().antMatchers("/webjars/**"
                , "/css/**"
                , "/js/**"
                , "/fonts/**"
                , "/img/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 「login.html」はログイン不要でアクセス可能に設定
                .antMatchers("/login").permitAll()
                .antMatchers("/status/**").permitAll()
                // 区分値マスタリキャッシュは自サーバからのアクセスのみ許可
                .antMatchers("/commons/cache/reload").hasIpAddress("127.0.0.1")
                //上記以外は直リンク禁止
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //ログイン処理のパス
                .loginProcessingUrl("/login")
                //ログインページ
                .loginPage("/login")
                //ログインエラー時の遷移先 ※パラメーターに「error」を付与
                .failureUrl("/login?error")
                //ログイン成功時の遷移先
                .defaultSuccessUrl("/top", true)
                //ログイン時のキー：名前
                .usernameParameter("loginId")
                //ログイン時のパスワード
                .passwordParameter("password")
                .and()
                .logout()
                //ログアウト時の遷移先 POSTでアクセス
                .logoutSuccessUrl("/login");
    }

    //パスワードのアルゴリズムをBCryptに設定
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
