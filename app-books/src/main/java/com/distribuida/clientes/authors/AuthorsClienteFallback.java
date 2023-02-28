package com.distribuida.clientes.authors;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

@ApplicationScoped
public class AuthorsClienteFallback implements FallbackHandler<AuthorsCliente> {
    @Override
    public AuthorsCliente handle(ExecutionContext context) {
        AuthorsCliente authorsCliente = new AuthorsCliente();
        authorsCliente.setFirtName("no disponible en este momento, intentelo más tarde");
        authorsCliente.setLastName("no disponible en este momento, intentelo más tarde");
        return authorsCliente;
    }
}
