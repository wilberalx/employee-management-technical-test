import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatIconButton } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-delete-cell-renderer',
  templateUrl: './delete-cell-renderer.component.html',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatIconButton
  ],
})
export class DeleteCellRendererComponent {
  params: any;

  agInit(params: any): void {
    this.params = params;
  }

  onClick(event: MouseEvent) {
    event.stopPropagation();
    if (this.params.onDelete) {
      this.params.onDelete(this.params.data);
    }
  }
}
