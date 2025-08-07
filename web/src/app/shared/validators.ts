import { AbstractControl, ValidationErrors } from "@angular/forms";

export function phoneUSValidator(control: AbstractControl): ValidationErrors | null {
  const phoneRegex = /^(\+1\s?)?(\([0-9]{3}\)|[0-9]{3})([-.\s]?)[0-9]{3}([-.\s]?)[0-9]{4}$/;
  const valid = phoneRegex.test(control.value);
  return valid ? null : { invalidPhone: true };
}
