import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatIconButton } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-edit-cell-renderer',
  templateUrl: './edit-cell-renderer.component.html',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatIconButton
  ],
})
export class EditCellRendererComponent {
  params: any;

  agInit(params: any): void {
    this.params = params;
  }

  onClick(event: MouseEvent) {
    event.stopPropagation();
    if (this.params.onEdit) {
      this.params.onEdit(this.params.data);
    }
  }
}
