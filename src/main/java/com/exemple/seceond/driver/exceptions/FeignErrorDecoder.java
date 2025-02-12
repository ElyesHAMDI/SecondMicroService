package com.exemple.seceond.driver.exceptions;

import com.exemple.seceond.core.domain.exception.UnauthorizedAccessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 403) {
            return new UnauthorizedAccessException("Accès refusé par le microservice d'autorisation.");
        } else if (response.status() == 404) {
            return new NotFoundEntityException("Ressource non trouvée", "Détails non trouvés");
        }
        return new RuntimeException("Erreur inattendue lors de l'appel au microservice");
    }
}

