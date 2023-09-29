package med.voll.api.domain.paciente;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(
        Long id,
        Long idPaciente,
        Long idMedico,
        LocalDateTime fecha) {
}
