import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaUsuarioComponent } from './components/lista-usuario/lista-usuario.component';
import {RegistrarUsuarioComponent} from "./components/registrar-usuario/registrar-usuario.component";
import {ActualizarUsuarioComponent} from "./components/actualizar-usuario/actualizar-usuario.component";

const routes: Routes = [ //usado para definir las rutas de la aplicación
  {path: 'usuarios', component:ListaUsuarioComponent }, //ruta para la lista de usuarios
  {path: '', redirectTo: '/usuarios', pathMatch: 'full'}, //ruta por defecto
  {path: 'registrar-usuario',component:RegistrarUsuarioComponent}, //ruta para registrar un usuario
  { path: 'actualizar-usuario/:cedula', component: ActualizarUsuarioComponent } //ruta para actualizar un usuario

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
