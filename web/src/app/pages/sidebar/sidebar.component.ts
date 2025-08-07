import { Component, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { MenuOption, MenuService } from '../../core/services/shared/menus.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    RouterLink,
    RouterModule
  ],
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {

  @Output() closeMenu = new EventEmitter<void>();

  menuOptions: MenuOption[] = [];

  constructor(
    private router: Router,
    private menuService: MenuService
  ) {
    this.menuOptions = this.menuService.menuOptions;
  }

  onCloseMenu() {
    this.closeMenu.emit();
  }

  navigate(option: any) {
    this.router.navigate([option.route]);
  }

}
