import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario, UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-actualizar-usuario',
  templateUrl: './actualizar-usuario.component.html',
  styleUrls: ['./actualizar-usuario.component.css']
})
export class ActualizarUsuarioComponent implements OnInit {
  usuario: Usuario = new Usuario(); // Instancia inicial del usuario

  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Obtiene la cédula del usuario desde la URL
    const cedula = this.route.snapshot.paramMap.get('cedula');
    if (cedula) {
      this.cargarUsuario(cedula);
    }
  }
  //usado para cargar el usuario
  cargarUsuario(cedula: string): void {
    this.usuarioService.getUsuario(cedula).subscribe({
      next: (usuario) => {
        this.usuario = usuario;
      },
      error: (error) => {
        console.error('Error al cargar el usuario:', error);
        alert('No se pudo cargar el usuario. Verifica la cédula o intenta más tarde.');
      }
    });
  }
      //usado para actualizar el usuario
  onSubmit(): void {
    this.usuarioService.actualizarUsuario(this.usuario).subscribe({
      next: () => {
        alert('Usuario actualizado correctamente.');
        this.router.navigate(['/usuarios']); // Redirige a la lista de usuarios
      },
      error: (error) => {
        console.error('Error al actualizar el usuario:', error);
        alert('Hubo un problema al actualizar el usuario. Intenta de nuevo.');
      }
    });
  }
  //usado para cancelar la actualizacion
  cancelar(): void {
    this.router.navigate(['/usuarios']); // Redirige a la lista de usuarios sin realizar cambios
  }
}
