package main.java.com.codechallenge.auth.client;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import com.codechallenge.auth.dto.UserDTO;
import com.codechallenge.auth.dto.UserUpdateRequest;
import com.codechallenge.auth.dto.SubmissionHistoryDTO;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;

@Service
@RequiredArgsConstructor
public class UserServiceClient {
    private final WebClient.Builder webClientBuilder;

    public UserDTO createUser(UserDTO userDTO) {
        return webClientBuilder.build()
            .post()
            .uri("http://localhost:8081/users/create")
            .body(userDTO)
            .retrieve()
            .bodyToMono(UserDTO.class)
            .block();
    }
}
