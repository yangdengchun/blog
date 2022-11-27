package com.example.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author ydc
 * @create 2022-09-20 23:49
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTION".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getParameter("token");
        ResultVo vo = new ResultVo(ResultStatus.NO, "请先登录", null);
        if (token == null){
            doResponse(response,vo);
        }else {
            try {
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("123456");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                //可以取到body的值
                //Claims body = claimsJws.getBody();
                //System.out.println(body.get("name"));
                return true;

            }catch (ExpiredJwtException e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "登录过期,请重新登录", null);
                doResponse(response,resultVo);
            }catch (UnsupportedJwtException e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "Token不合法", null);
                doResponse(response,resultVo);
            }catch (Exception e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "请先登录", null);
                doResponse(response,resultVo);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response,ResultVo vo) throws IOException {
        response.setContentType("application/json");//提示返回json
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();//获取流
        String s = new ObjectMapper().writeValueAsString(vo);//将数据序列化为json格式
        out.print(s);
        out.flush();
        out.close();

    }
}

