# vimhelp-minimal

This is a fork of the excellent [liquidz/clj-vimhelp](https://github.com/liquidz/clj-vimhelp) library which aims to provide a more minimal interface, with some slight tweaks to the html rendering.

## `vimhelp.core`
Parse vim help files into Clojure data structures:
- Intermediate representation (Hiccup w/ custom tags): `vimhelp.core/help-file->ir`
- Hiccup (HTML tags): `vimhelp.core/help-file->hiccup`
- HTML fragment: `vimhelp.core/help-file->html`

## `vimhelp.parse`
Responsible for parsing input file to intermediate representation.

## `vimhelp.html`
Responsible for converting intermediate representation into Hiccup.
