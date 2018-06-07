/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { VsBodyTemperatureComponent } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.component';
import { VsBodyTemperatureService } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.service';
import { VsBodyTemperature } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.model';

describe('Component Tests', () => {

    describe('VsBodyTemperature Management Component', () => {
        let comp: VsBodyTemperatureComponent;
        let fixture: ComponentFixture<VsBodyTemperatureComponent>;
        let service: VsBodyTemperatureService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBodyTemperatureComponent],
                providers: [
                    VsBodyTemperatureService
                ]
            })
            .overrideTemplate(VsBodyTemperatureComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBodyTemperatureComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBodyTemperatureService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VsBodyTemperature('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vsBodyTemperatures[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
