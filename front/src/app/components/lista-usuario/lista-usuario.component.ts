import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService, Usuario } from '../../services/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css'],
})
export class ListaUsuarioComponent implements OnInit {
  usuarios: Usuario[] = []; // Lista completa de usuarios
  usuariosFiltrados: Usuario[] = []; // Lista de usuarios filtrados
  cedulaBusqueda: string = ''; // Cédula ingresada para la búsqueda

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerUsuarios();
  }
  //usado para obtener los usuarios
  obtenerUsuarios(): void {
    this.usuarioService.getUsuarios().subscribe({
      next: (data) => {
        this.usuarios = data;
        this.usuariosFiltrados = data; // Inicialmente, muestra todos los usuarios
      },
      error: (error) => {
        console.error('Error al obtener los usuarios:', error);
      },
    });
  }
  //usado para buscar por cedula
  buscarPorCedula(): void {
    const cedula = this.cedulaBusqueda.trim().toLowerCase();
    if (cedula) {
      this.usuariosFiltrados = this.usuarios.filter((usuario) =>
        usuario.cedula.toLowerCase().includes(cedula)
      );
    } else {
      this.usuariosFiltrados = [...this.usuarios]; // Si no hay cédula ingresada, muestra todos los usuarios
    }
  }
 //usado para eliminar el usuario
  eliminarUsuario(cedula: string): void {
    this.usuarioService.eliminarUsuario(cedula).subscribe({
      next: () => {
        alert('Usuario eliminado correctamente.');
        this.obtenerUsuarios(); // Refresca la lista después de eliminar
      },
      error: (error) => {
        console.error('Error al eliminar el usuario:', error);
      },
    });
  }

  editarUsuario(cedula: string): void {
    // Navega al componente de edición con la cédula del usuario como parámetro
    this.router.navigate(['/actualizar-usuario', cedula]);
  }
}
