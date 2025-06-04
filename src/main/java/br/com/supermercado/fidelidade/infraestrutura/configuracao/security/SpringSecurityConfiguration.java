package br.com.supermercado.fidelidade.infraestrutura.configuracao.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
        Observação!
        Foi utilizado nesse teste a autenticação básica, porém em sistemas em produção é
        recomendado utilizar: JWT ou OAuth2 (tokens enviado ao usuário após autenticação)
        Em um cenário produtivo, provavelmente teriamos um Servidor API Gateway que
        seria responsável pela segurança das APIs.

        [Cliente]
           |
           | 1. POST /auth/login (com credenciais)
           V
        [API Gateway] ← autentica, gera JWT
           |
           | 2. Responde com token
           V
        [Cliente armazena token]
           |
           | 3. GET /usuarios (com Authorization: Bearer <token>)
           V
        [API Gateway] → Valida JWT e redireciona
           |
           V
        [Serviço de Usuários]
           |
           V
           Retorna response da API GET /usuarios para o cliente

         As tecnologias comuns para montar um gateway seriaAWS API Gateway:
         AWS API Gateway
         Spring Cloud Gateway
         Kong Gateway
         etc..
         */

//        Segurança do Spring
//        1) Todas as solicitações devem ser autenticadas
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//        2) Se uma solicitação não for autenticada, uma página da web será exibida (somente navegador)
        http.httpBasic(Customizer.withDefaults());
//        3) CSRF -> POST, PUT (desabilitado para funcionar com verbos http como post, put, patch)
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
